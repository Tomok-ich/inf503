import java.io.FileWriter;

public class HtmlExporter {

    public static void export(DatabaseUtils db) throws Exception {

        StringBuilder html = new StringBuilder();

        html.append("""
                <!DOCTYPE html>
                <html>
                <head>
                    <meta charset="utf-8"/>
                </head>
                <body>
                <h1>Доходы/Расходы</h1>
                <table border="1">
                <tr>
                    <th>id</th><th>Тип</th><th>Название</th>
                    <th>Сумма</th><th>Дата</th><th>Примечание</th>
                </tr>
                """);

        for (int i = 1; i <= 1000; i++) {
            Many m = db.findById(i);
            if (m != null) {
                html.append("<tr>")
                        .append("<td>").append(m.getId()).append("</td>")
                        .append("<td>").append(m.getType() == 1 ? "Доход" : "Расход").append("</td>")
                        .append("<td>").append(m.getName()).append("</td>")
                        .append("<td>").append(m.getSumm()).append("</td>")
                        .append("<td>").append(m.getDate()).append("</td>")
                        .append("<td>").append(m.getComment()).append("</td>")
                        .append("</tr>");
            }
        }

        html.append("""
                </table>
                </body>
                </html>
                """);

        try (FileWriter fw = new FileWriter("students.html")) {
            fw.write(html.toString());
        }
    }
}
