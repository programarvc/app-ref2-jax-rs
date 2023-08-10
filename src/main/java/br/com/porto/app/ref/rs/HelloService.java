/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.porto.app.ref.rs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple CDI service which is able to say hello to someone
 * 
 * @author Pete Muir
 * 
 */
public class HelloService {

	private String pathFolder = "\\temp\\re\\db.txt";
	private List<EmpresaDTO> empresas = new ArrayList<EmpresaDTO>(0);

	String createHelloMessage(String name) {
		return "Hello " + name + "!";
	}

	public List<EmpresaDTO> create(EmpresaDTO pojoModel)
			throws URISyntaxException {

		loadEmpresa(false);

		if (empresas == null) {
			empresas = new ArrayList<EmpresaDTO>(0);
		}

		pojoModel.setCodigoEmpresa(generateId());

		empresas.add(pojoModel);

		loadEmpresa(true);

		return empresas;
	}

	public List<EmpresaDTO> findAll() {
		loadEmpresa(false);
		return this.empresas;
	}

	public void update(EmpresaDTO empresaDTO) {
		this.empresas = this.findAll();
		this.empresas.set(this.empresas.indexOf(empresaDTO), empresaDTO);

		this.loadEmpresa(true);
	}

	public EmpresaDTO findByCodeAndName(EmpresaDTO pEmpresaDTO) {
		EmpresaDTO empresaDTO = null;
		// this.empresas = threadLocal.get();
		loadEmpresa(false);
		Integer idxOff = null;
		String nomeEmpresa = pEmpresaDTO.getNomeEmpresa();
		Integer codigoEmpresa = pEmpresaDTO.getCodigoEmpresa();
		if (codigoEmpresa != null
				&& (nomeEmpresa == null || nomeEmpresa.length() == 0)) {
			idxOff = this.empresas.indexOf(pEmpresaDTO);
		} else {
			EmpresaComparator empComparator = new EmpresaComparator();
			// Collections.sort(empresas, empComparator);
			idxOff = Collections.binarySearch(empresas, pEmpresaDTO,
					empComparator);
		}

		if (idxOff >= 0) {
			empresaDTO = this.empresas.get(idxOff);
		}

		return empresaDTO;
	}

	private void loadEmpresa(Boolean serializa) {
		File fileResourceSerializado = new File(pathFolder);
		List<EmpresaDTO> filesResources = null;
		if (!fileResourceSerializado.exists() || serializa) {
			serialize(empresas);
		} else {
			empresas = deserialize();
		}
	}

	private Integer generateId() {
		loadEmpresa(false);
		EmpresaComparator empComparator = new EmpresaComparator();
		if (empresas != null && empresas.size() > 0) {
			Collections.sort(empresas, empComparator);
			return empresas.get(this.empresas.size() - 1).getCodigoEmpresa() + 1;
		} else {
			return 1;
		}
	}

	private List<EmpresaDTO> deserialize() {
		List<EmpresaDTO> list = null;

		try {
			FileInputStream fileInStr = new FileInputStream(pathFolder);
			ObjectInputStream oubjInStr = new ObjectInputStream(fileInStr);
			list = (List<EmpresaDTO>) oubjInStr.readObject();
			oubjInStr.close();
			fileInStr.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		return list;
	}

	private void serialize(List<EmpresaDTO> list) {

		try {
			FileOutputStream fileOutStr = new FileOutputStream(pathFolder);
			ObjectOutputStream oubjOutStr = new ObjectOutputStream(fileOutStr);
			oubjOutStr.writeObject(list);
			oubjOutStr.close();
			fileOutStr.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
