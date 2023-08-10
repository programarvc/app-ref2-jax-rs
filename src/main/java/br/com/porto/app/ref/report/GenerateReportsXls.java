package br.com.porto.app.ref.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


//http://stackoverflow.com/questions/29931681/google-combo-charts-with-stacked-bar-and-lines
public class GenerateReportsXls {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		List<Object[]> mapaPlanOriginal05 = new GenerateReportsXls()
				.readDataXls();
	}

	public List<Object[]> readDataXls() throws IOException {
		String planOriginal01 = "E:\\Documents\\PORTO_SEGURO\\TorreControleTiago.xlsx";
		String regexDataValid = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[12][0-9]{3}$";
		FileInputStream inputStream = new FileInputStream(new File(
				planOriginal01));
		SimpleDateFormat smdf = new SimpleDateFormat("dd/MM/yyyy");
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(1);
		Iterator<Row> iterator = firstSheet.iterator();
		DataExtractedXlsDTO dataRow = null;
		Set<String> papeisOriginal = null;
		// Iterator<Cell> cellIterator = null;
		Row nextRow = null;
		List<Object[]> dados = new ArrayList<Object[]>();
		Object[] dataLine = null;
		int contCell = 0;
		while (iterator.hasNext()) {
			nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			papeisOriginal = new HashSet<String>();
			dataRow = new DataExtractedXlsDTO();
			dataLine = new Object[nextRow.getLastCellNum()];
			contCell = 0;
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();

				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					System.out.println(cell.getStringCellValue());
					dataRow.setNameGraph(cell.getStringCellValue());
					// boolean isMatch = Pattern.matches(regexDataValid,
					// cell.getStringCellValue());
					// System.out.println(isMatch);
					dataLine[contCell] = cell.getStringCellValue();
					break;
				case Cell.CELL_TYPE_FORMULA:
					// System.out.println(cell.getNumericCellValue());
					dataLine[contCell] = cell.getNumericCellValue();
					break;
				case Cell.CELL_TYPE_NUMERIC:// aqui so cai as colunas de data
					// System.out.println(smdf.format(cell.getDateCellValue()));
					dataLine[contCell] = new BigDecimal(
							cell.getNumericCellValue());

					break;
				}
				contCell++;
			}

			dados.add(dataLine);
		}

		workbook.close();
		inputStream.close();

		return dados;
	}
}