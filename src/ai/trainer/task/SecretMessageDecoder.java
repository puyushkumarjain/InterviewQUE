package ai.trainer.task;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SecretMessageDecoder {

    static class GridPoint {
        char character;
        int x;
        int y;

        GridPoint(char character, int x, int y) {
            this.character = character;
            this.x = x;
            this.y = y;
        }
    }

    public static void printSecretMessage(String url) {
        try {
            // 1. Fetch and parse the HTML content
            Document doc = Jsoup.connect(url).get();
            Element table = doc.select("table").first();
            if (table == null) return;

            Elements rows = table.select("tr");
            if (rows.isEmpty()) return;

            // 2. Identify column indices dynamically
            Elements headerCells = rows.get(0).select("td, th");
            int xIdx = 0, charIdx = 1, yIdx = 2; // Default fallbacks
            for (int i = 0; i < headerCells.size(); i++) {
                String text = headerCells.get(i).text().toLowerCase();
                if (text.contains("x")) xIdx = i;
                else if (text.contains("y")) yIdx = i;
                else if (text.contains("char")) charIdx = i;
            }

            // 3. Extract data points into a flat list
            List<GridPoint> points = new ArrayList<>();
            for (int i = 1; i < rows.size(); i++) {
                Elements cells = rows.get(i).select("td, th");
                if (cells.size() <= Math.max(xIdx, Math.max(yIdx, charIdx))) continue;
                try {
                    int x = Integer.parseInt(cells.get(xIdx).text().trim());
                    int y = Integer.parseInt(cells.get(yIdx).text().trim());
                    String charText = cells.get(charIdx).text();
                    char character = charText.isEmpty() ? ' ' : charText.charAt(0);
                    points.add(new GridPoint(character, x, y));
                } catch (NumberFormatException ignored) {
                }
            }

            if (points.isEmpty()) return;

            // 4. SORT LOGIC: Sort by Y descending (top rows first), then X ascending (left to right)
            points.sort((a, b) -> {
                if (b.y != a.y) {
                    return Integer.compare(b.y, a.y); // Higher Y comes first
                }
                return Integer.compare(a.x, b.x);     // Lower X comes first
            });

            // 5. DIRECT CONSOLE PRINTING LOGIC (No matrix/table creation)
            int currentY = points.get(0).y;
            int currentX = 0;

            for (GridPoint point : points) {
                // If the Y coordinate drops, push cursor to the next line(s)
                while (currentY > point.y) {
                    System.out.println();
                    currentY--;
                    currentX = 0; // Reset horizontal cursor for the new row
                }

                // Print trailing empty spaces up to the target X coordinate
                while (currentX < point.x) {
                    System.out.print(' ');
                    currentX++;
                }

                // Print the actual character and advance cursor position
                System.out.print(point.character);
                currentX++;
            }
            System.out.println(); // Final line break

        } catch (IOException e) {
            System.out.println("Error fetching document: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String targetUrl = "https://docs.google.com/document/d/e/2PACX-1vSvM5gDlNvt7npYHhp_XfsJvuntUhq184By5xO_pA4b_gCWeXb6dM6ZxwN8rE6S4ghUsCj2VKR21oEP/pub";
        printSecretMessage(targetUrl);
    }
}

