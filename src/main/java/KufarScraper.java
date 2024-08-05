////
////import okhttp3.*;
////import org.jsoup.Jsoup;
////import org.jsoup.nodes.Document;
////import org.jsoup.nodes.Element;
////import org.jsoup.select.Elements;
////
////import java.io.*;
////import java.util.HashSet;
////import java.util.Set;
////
////public class KufarScraper {
////
////    private static final String URL = "https://re.kufar.by/l/minsk/snyat/komnatu-dolgosrochno?cur=BYR&gbx=b%3A27.077931849609367%2C53.642394996031655%2C28.377065150390607%2C54.12191339443684&size=30";
////    private static final String TELEGRAM_API_URL = "https://api.telegram.org/bot";
////    private static final String BOT_TOKEN = "7197956065:AAFSPJJhviSiGDtdHwY3dw-LrpCgXpsqzIw"; // Ваш токен бота
////    private static final String CHAT_ID1 = "1356918059"; // Ваш chat ID
////    private static final String CHAT_ID = "530471423"; // Ваш chat ID
////    private static final String FILE_PATH = "processed_locations.txt";
////
////    private static Set<String> processedLocations = new HashSet<>();
////
////    public static void main(String[] args) {
////        loadProcessedLocations(); // Загрузить существующие записи из файла
////
////        while (true) {
////            try {
////                System.out.println("Starting scraping process...");
////                scrapeKufar();
////                System.out.println("Scraping completed, sleeping for 30 seconds...");
////                Thread.sleep(60000); // Ждать 30 секунд перед следующей проверкой
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
////        }
////    }
////
////    // Загрузка существующих записей из файла
////    private static void loadProcessedLocations() {
////        File file = new File(FILE_PATH);
////        if (file.exists()) {
////            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
////                String line;
////                while ((line = reader.readLine()) != null) {
////                    processedLocations.add(line.trim());
////                }
////            } catch (IOException e) {
////                System.err.println("Failed to load processed locations: " + e.getMessage());
////            }
////        }
////    }
////
////    // Сохранение записей в файл
////    private static void saveProcessedLocations() {
////        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
////            for (String location : processedLocations) {
////                writer.write(location);
////                writer.newLine(); // Добавляем перевод строки
////            }
////        } catch (IOException e) {
////            System.err.println("Failed to save processed locations: " + e.getMessage());
////        }
////    }
////
////    private static void scrapeKufar() throws IOException {
////        Document doc = Jsoup.connect(URL).get();
////        System.out.println("HTML content loaded successfully!");
////
////        Elements ads = doc.select("#content > div.styles_ads__QM8HX > div.styles_wrapper__vfncA > div > section:nth-child(1)");
////        System.out.println("Found " + ads.size() + " advertisements.");
////
////        boolean newAdsFound = false;
////
////        for (Element ad : ads) {
////            String title = ad.select(".styles_parameters__7zKlL").text();
////            String price = ad.select(".styles_price__byr__lLSfd").text();
////            String location = ad.select(".styles_address__l6Qe_").text();
////            String link = ad.select("a").attr("href");
////
////           if (!processedLocations.contains(location)) {
////                processedLocations.add(location);
////                System.out.println("New advertisement found: " + title);
////                sendTelegramMessage("Новое объявление о сдаче комнаты", "Title: " + title + "\nРасположение: " + location + "\nЦена: " + price + "\n" + link);
////               newAdsFound = true;
////            }
////        }
////
////        if (newAdsFound) {
////           saveProcessedLocations(); // Сохраняем записи, если были найдены новые объявления
////       } else {
////         System.out.println("No new ads found.");
////       }
////    }
////
////    private static void sendTelegramMessage(String subject, String content) {
////        OkHttpClient client1 = new OkHttpClient();
////        OkHttpClient client = new OkHttpClient();
////        String url = TELEGRAM_API_URL + BOT_TOKEN + "/sendMessage";
////        String message = subject + "\n" + content;
////
////        RequestBody body = new FormBody.Builder()
////                .add("chat_id", CHAT_ID1)
////                .add("chat_id", CHAT_ID)
////                .add("text", message)
////                .add("text", message)
////                .build();
////
////
////        Request request = new Request.Builder()
////                .url(url)
////                .post(body)
////                .build();
////
////        try {
////            Response response1 = client1.newCall(request).execute();
////            Response response = client.newCall(request).execute();
////
////
////            if (response1.isSuccessful() && response.isSuccessful()) {
////                System.out.println("Telegram message sent successfully to chat ID " + CHAT_ID1);
////                System.out.println("Telegram message sent successfully to chat ID " + CHAT_ID);
////            } else {
////                System.err.println("Failed to send Telegram message: " + response.message());
////            }
////        } catch (IOException e) {
////            System.err.println("Failed to send Telegram message: " + e.getMessage());
////            e.printStackTrace();
////        }
////    }
////}
//
//import okhttp3.*;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.io.*;
//import java.util.HashSet;
//import java.util.Set;
//
//public class KufarScraper {
//
//    private static final String URL = "https://re.kufar.by/l/minsk/snyat/komnatu-dolgosrochno?cur=BYR&gbx=b%3A27.077931849609367%2C53.642394996031655%2C28.377065150390607%2C54.12191339443684&size=30";
//    private static final String TELEGRAM_API_URL = "https://api.telegram.org/bot";
//    private static final String BOT_TOKEN = "7197956065:AAFSPJJhviSiGDtdHwY3dw-LrpCgXpsqzIw"; // Ваш токен бота
//    private static final String CHAT_ID1 = "1356918059"; // Ваш chat ID
//    private static final String CHAT_ID2 = "530471423"; // Второй chat ID
//    private static final String FILE_PATH = "processed_locations.txt";
//
//    private static Set<String> processedLocations = new HashSet<>();
//
//    public static void main(String[] args) {
//        loadProcessedLocations(); // Загрузить существующие записи из файла
//
//        while (true) {
//            try {
//                System.out.println("Starting scraping process...");
//                scrapeKufar();
//                System.out.println("Scraping completed, sleeping for 30 seconds...");
//                Thread.sleep(60000); // Ждать 60 секунд перед следующей проверкой
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    // Загрузка существующих записей из файла
//    private static void loadProcessedLocations() {
//        File file = new File(FILE_PATH);
//        if (file.exists()) {
//            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    processedLocations.add(line.trim());
//                }
//            } catch (IOException e) {
//                System.err.println("Failed to load processed locations: " + e.getMessage());
//            }
//        }
//    }
//
//    // Сохранение записей в файл
//    private static void saveProcessedLocations() {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
//            for (String location : processedLocations) {
//                writer.write(location);
//                writer.newLine(); // Добавляем перевод строки
//            }
//        } catch (IOException e) {
//            System.err.println("Failed to save processed locations: " + e.getMessage());
//        }
//    }
//
//    private static void scrapeKufar() throws IOException {
//        Document doc = Jsoup.connect(URL).get();
//        System.out.println("HTML content loaded successfully!");
//
//        Elements ads = doc.select("#content > div.styles_ads__QM8HX > div.styles_wrapper__vfncA > div > section:nth-child(1)");
//        System.out.println("Found " + ads.size() + " advertisements.");
//
//        boolean newAdsFound = false;
//
//        for (Element ad : ads) {
//            String title = ad.select(".styles_parameters__7zKlL").text();
//            String price = ad.select(".styles_price__byr__lLSfd").text();
//            String location = ad.select(".styles_address__l6Qe_").text();
//            String link = ad.select("a").attr("href");
//
//            if (!processedLocations.contains(location)) {
//                processedLocations.add(location);
//                System.out.println("New advertisement found: " + title);
//                sendTelegramMessage("Новое объявление о сдаче комнаты", "Title: " + title + "\nРасположение: " + location + "\nЦена: " + price + "\n" + link);
//                newAdsFound = true;
//            }
//        }
//
//        if (newAdsFound) {
//            saveProcessedLocations(); // Сохраняем записи, если были найдены новые объявления
//        } else {
//            System.out.println("No new ads found.");
//        }
//    }
//
//    private static void sendTelegramMessage(String subject, String content) {
//        OkHttpClient client = new OkHttpClient();
//        String url = TELEGRAM_API_URL + BOT_TOKEN + "/sendMessage";
//        String message = subject + "\n" + content;
//
//        // Отправка сообщения первому пользователю
//        sendMessageToChat(client, url, CHAT_ID1, message);
//
//        // Отправка сообщения второму пользователю
//        sendMessageToChat(client, url, CHAT_ID2, message);
//    }
//
//    private static void sendMessageToChat(OkHttpClient client, String url, String chatId, String message) {
//        RequestBody body = new FormBody.Builder()
//                .add("chat_id", chatId)
//                .add("text", message)
//                .build();
//
//        Request request = new Request.Builder()
//                .url(url)
//                .post(body)
//                .build();
//
//        try {
//            Response response = client.newCall(request).execute();
//            if (response.isSuccessful()) {
//                System.out.println("Telegram message sent successfully to chat ID " + chatId);
//            } else {
//                System.err.println("Failed to send Telegram message to chat ID " + chatId + ": " + response.message());
//            }
//        } catch (IOException e) {
//            System.err.println("Failed to send Telegram message to chat ID " + chatId + ": " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//}
//

import okhttp3.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class KufarScraper {

    private static final String URL = "https://re.kufar.by/l/minsk/snyat/komnatu-dolgosrochno?cur=BYR&gbx=b%3A27.077931849609367%2C53.642394996031655%2C28.377065150390607%2C54.12191339443684&size=30";
    private static final String TELEGRAM_API_URL = "https://api.telegram.org/bot";
    private static final String BOT_TOKEN = System.getenv("BOT_TOKEN"); // Ваш токен бота
    private static final String CHAT_ID1 = System.getenv("CHAT_ID1"); // Ваш chat ID
    private static final String CHAT_ID = System.getenv("CHAT_ID"); // Ваш chat ID
    private static final String FILE_PATH = "processed_locations.txt";

    private static Set<String> processedLocations = new HashSet<>();

    public static void main(String[] args) {
        loadProcessedLocations(); // Загрузить существующие записи из файла

        while (true) {
            try {
                System.out.println("Starting scraping process...");
                scrapeKufar();
                System.out.println("Scraping completed, sleeping for 30 seconds...");
                Thread.sleep(60000); // Ждать 30 секунд перед следующей проверкой
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Загрузка существующих записей из файла
    private static void loadProcessedLocations() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    processedLocations.add(line.trim());
                }
            } catch (IOException e) {
                System.err.println("Failed to load processed locations: " + e.getMessage());
            }
        }
    }

    // Сохранение записей в файл
    private static void saveProcessedLocations() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String location : processedLocations) {
                writer.write(location);
                writer.newLine(); // Добавляем перевод строки
            }
        } catch (IOException e) {
            System.err.println("Failed to save processed locations: " + e.getMessage());
        }
    }

    private static void scrapeKufar() throws IOException {
        Document doc = Jsoup.connect(URL).get();
        System.out.println("HTML content loaded successfully!");

        Elements ads = doc.select("#content > div.styles_ads__QM8HX > div.styles_wrapper__vfncA > div > section:nth-child(1)");
        System.out.println("Found " + ads.size() + " advertisements.");

        boolean newAdsFound = false;

        for (Element ad : ads) {
            String title = ad.select(".styles_parameters__7zKlL").text();
            String price = ad.select(".styles_price__byr__lLSfd").text();
            String location = ad.select(".styles_address__l6Qe_").text();
            String link = ad.select("a").attr("href");

            if (!processedLocations.contains(location)) {
                processedLocations.add(location);
                System.out.println("New advertisement found: " + title);
                sendTelegramMessage("Новое объявление о сдаче комнаты", "Title: " + title + "\nРасположение: " + location + "\nЦена: " + price + "\n" + link);
                newAdsFound = true;
            }
        }

        if (newAdsFound) {
            saveProcessedLocations(); // Сохраняем записи, если были найдены новые объявления
        } else {
            System.out.println("No new ads found.");
        }
    }

    private static void sendTelegramMessage(String subject, String content) {
        OkHttpClient client = new OkHttpClient();
        String url = TELEGRAM_API_URL + BOT_TOKEN + "/sendMessage";
        String message = subject + "\n" + content;

        RequestBody body = new FormBody.Builder()
                .add("chat_id", CHAT_ID1)
                .add("text", message)
                .build();

        RequestBody body2 = new FormBody.Builder()
                .add("chat_id", CHAT_ID)
                .add("text", message)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Request request2 = new Request.Builder()
                .url(url)
                .post(body2)
                .build();

        try {
            Response response = client.newCall(request).execute();
            Response response2 = client.newCall(request2).execute();
            if (response.isSuccessful() && response2.isSuccessful()) {
                System.out.println("Telegram message sent successfully to chat IDs " + CHAT_ID1 + " and " + CHAT_ID);
            } else {
                System.err.println("Failed to send Telegram message: " + response.message());
            }
        } catch (IOException e) {
            System.err.println("Failed to send Telegram message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
