package br.com.porto.app.ref.rs;

import java.util.Comparator;

public class EmpresaComparator implements Comparator<EmpresaDTO> {

	public EmpresaComparator() {
	}

	@Override
	public int compare(EmpresaDTO c1, EmpresaDTO c2) {
		if (c1 == null || c2 == null)
			throw new ClassCastException("null");

		String nome1 = c1.getNomeEmpresa(), nome2 = c2.getNomeEmpresa();

		return nome1.compareTo(nome2);
	}
}
