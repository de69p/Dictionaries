import java.util.*;

public class FileNavigator2 {
    private Map<String, List<FileData>> map = new HashMap<>();

    //Реалізувати метод add у класі FileNavigator
    // Цей метод додає файл за вказаним шляхом
    // Якщо шлях вже існує, новий файл необхідно додати до списку,
    // вже пов'язаному з відповідним шляхом. ВАЖЛИВО: Шлях – унікальне значення і не повинно повторюватися.
    public void add(FileData file) {
        if (map.containsKey(file.getPath())) {
            List<FileData> fileData = map.get(file.getPath());
            fileData.add(file);
        } else {
            List<FileData> listOfFiles = new ArrayList<>();
            listOfFiles.add(file);
            map.put(file.getPath(), listOfFiles);
        }
    }

    //    Реалізувати метод find у класі FileNavigator
    //    Метод повертає список файлів, пов'язаних з шляхом переданим як параметр
    public List<FileData> find(String path) {
        List<FileData> filesData = map.get(path);
        return filesData;
    }

    // Реалізувати метод filterBySize у класі FileNavigator
    // Метод повертає список файлів, розмір (в байтах) яких не перевищує значення, передане як параметр
    public List<FileData> filterBySize(int size) {
        List<FileData> outputArray = new ArrayList<>();
        for (List<FileData> files : map.values()) {
            for (FileData file : files) {
                if (file.getFileSize() < size) {
                    outputArray.add(file);
                }
            }
        }
        return outputArray;
    }

    //    Реалізувати метод remove у класі FileNavigator.
    //    Метод видаляє шлях і пов'язані з ним файли, виходячи з значення шляху, переданого як параметр.
    public void remove(String path) {
        List<FileData> files = new ArrayList<>();
        map.put(path, files);
        map.remove(path);
    }

    // Реалізувати метод sortBySize у класі FileNavigator
    // Метод сортує всі наявні файли за розміром (за зростанням),
    // потім повертає список відсортованих файлів
    public List<FileData> sortBySize(int size) {
        TreeSet<FileData> fileData = new TreeSet<>((newFile, newestFile) -> newFile.getFileSize() - newestFile.getFileSize());
        for (List<FileData> files : map.values()) {
            for (FileData file : files) {
                if (file.getFileSize() < size) fileData.add(file);
            }
        }
        return fileData.stream().toList();
    }

    //Реалізувати перевірку консистентності у методі add у класі FileNavigator.
    //Не дозволяти додавати значення і повідомити про це в консолі,
    //при спробі додати значення FileData значення шляху якого не відповідає шляху-ключу, що веде до списку файлів.

}


