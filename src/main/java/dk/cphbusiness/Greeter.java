package dk.cphbusiness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toCollection;

public class Greeter {

    public String greet(String... names) {
        if (names == null) {
            return "Hello, my friend.";
        }

        ArrayList<String> nameList = Arrays.stream(names)
                .map((name) -> List.of(name.matches("\\\".+\\\"") ? new String[]{name} : name.split(",")))
                .flatMap(List::stream)
                .map(String::trim)
                .collect(toCollection(ArrayList::new));

        for (int i = 0; i < nameList.size() - 1; i++) {
            for (int j = 1; j < nameList.size(); j++) {
                if (nameList.get(i).equals(nameList.get(i).toUpperCase()) && !nameList.get(j)
                        .equals(nameList.get(j).toUpperCase())) {
                    String tmp = nameList.get(i);
                    nameList.set(i, nameList.get(j));
                    nameList.set(j, tmp);
                }
            }
        }
        System.out.println(nameList);
        int begunShoutingIndex = nameList.size();
        boolean doesShout = false;
        for (int i = 0; i < nameList.size(); i++) {
            if (nameList.get(i).equals(nameList.get(i).toUpperCase())) {
                begunShoutingIndex = i;
                doesShout = true;
                break;
            }
        }

        StringBuilder greeting = new StringBuilder();
        for (int i = 0; i < nameList.size(); ++i) {
            String name = nameList.get(i);
            if (i == 0 && !name.equals(name.toUpperCase())) {
                greeting.append("Hello, ");
            }

            if (i == begunShoutingIndex && doesShout) {
                if (i != 0) {
                    greeting.append(". AND ");
                }
                greeting.append("HELLO ");
            }

            if (i != 0 && begunShoutingIndex > i) {
                if (i == begunShoutingIndex - 1) greeting.append(" and ");
                else if (i != begunShoutingIndex - 1) {
                    greeting.append(", ");
                }
            }
            if (i >= begunShoutingIndex && doesShout) {
                greeting.append(name.toUpperCase());
            } else {
                greeting.append(name);
            }
        }

        if (doesShout) greeting.append("!");
        else greeting.append(".");

        return greeting.toString();
    }
}
