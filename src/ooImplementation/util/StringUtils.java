package ooImplementation.util;

import java.util.List;

public class StringUtils {

    public static String join(List<String> stringsList, String separator) {
        StringBuilder reducedString = new StringBuilder("");
        for (int i = 0; i < stringsList.size(); i++) {
            reducedString.append(stringsList.get(i));
            var hasNext = i < stringsList.size() - 1;
            if (hasNext) {
                reducedString.append(separator).append(" ");
            }
        }
        return reducedString.toString();
    }
}
