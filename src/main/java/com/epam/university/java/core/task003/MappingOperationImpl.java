package com.epam.university.java.core.task003;

public class MappingOperationImpl implements MappingOperation {
    @Override
    public String map(String source) {
        char[] in = source.toCharArray();
        int left=0;
        int right=in.length-1;
        char temp;
        while(right > left){
            temp = in[left];
            in[left] = in[right];
            in[right] = temp;
            right--;
            left++;
        }
        return new String(in);
    }
}
