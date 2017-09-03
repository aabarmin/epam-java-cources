package com.epam.university.java.core.task003;

public class FlatMappingOperationImpl implements FlatMappingOperation {
    @Override
    public String[] flatMap(String source) {
        int sizeOfOutput = 0;
        String outputStr = "";
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) >= '0' && source.charAt(i) <= '9') {
                sizeOfOutput++;
                do {
                    outputStr += source.charAt(i);
                    i++;
                } while (i < source.length() && source.charAt(i) >= '0' && source.charAt(i) <= '9');
                outputStr += " ";
            }
        }
        String[] preOutput = new String[sizeOfOutput];
        int j = 0;
        for (int i = 0; i < sizeOfOutput; i++) {
            preOutput[i] = "";
            while (j < outputStr.length() && outputStr.charAt(j) != ' ') {
                preOutput[i] += outputStr.charAt(j++);
            }
            j++;
        }
        String[] output = new String[0];
        String[] temp;
        Task003Impl assistant = new Task003Impl();
        for (int i = 0; i < preOutput.length; i++) {
            temp = new String[] {""};
            temp[0] = preOutput[i];
            temp = assistant.removeElements(temp, output);
            output = assistant.join(output, temp);
        }
        return output;
    }
}
