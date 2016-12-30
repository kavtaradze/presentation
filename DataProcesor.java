import java.util.List;

/**
 * Created by Guga on 12/15/2016.
 */
public class DataProcesor {
    public static String convert(List<Person> persons){
        StringBuilder sb = new StringBuilder();
        sb.append("<table>" +
                "  <tr>" +
                "    <th>Name</th>" +
                "    <th>Surname</th>" +
                "    <th>Email</th>" +
                "  </tr>");

        for(Person person : persons){
            sb.append("<tr>" +
                    "    <td>" + person.getName() + "</td>" +
                    "    <td>" + person.getSurname() + "</td> " +
                    "    <td>" + person.getEmail() + "</td>" +
                    "</tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }
}
