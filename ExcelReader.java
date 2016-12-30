import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guga on 12/15/2016.
 */
public class ExcelReader {
    public static List<Person> getData(String fileName) {
        List<Person> personList = new ArrayList<Person>();
        try {

            FileInputStream file = new FileInputStream(fileName);

            //Get the workbook instance for XLS file
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = workbook.getSheetAt(0);

            for (Row myrow : sheet) {
                if(myrow == sheet.getRow(0)) {
                    continue;
                }
                Person person = new Person(
                        myrow.getCell(0).toString(),
                        myrow.getCell(1).toString(),
                        myrow.getCell(2).toString()
                );
                personList.add(person);
            }
            for(Person person: personList) {
                System.out.printf(person.getName()+" ");
                System.out.printf(person.getSurname()+" ");
                System.out.printf(person.getEmail());
                System.out.println();
            }
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personList;
    }
}
