package streams;

import model.Notes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {

    public static void main(String[] args) {
        List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes(1, "note1", 12));
        noteLst.add(new Notes(2, "note2", 22));
        noteLst.add(new Notes(3, "note3", 33));
        noteLst.add(new Notes(4, "note4", 44));
        noteLst.add(new Notes(5, "note5", 55));

        noteLst.add(new Notes(6, "note4", 66));
        noteLst.add(new Notes(7, "note1", 101));


        Map<String, Integer> notesRecords = noteLst.stream()
                .sorted(Comparator
                        .comparingLong(Notes::getId)
                        .reversed()) // sorting is based on TagId 55,44,33,22,11
                .collect(Collectors.toMap
                        (Notes::getName, Notes::getValue,
                                (newValue, oldValue) -> oldValue, LinkedHashMap::new));
// consider old value 44 for dupilcate key
// it keeps order
        System.out.println("Notes : " + notesRecords);

}
}
