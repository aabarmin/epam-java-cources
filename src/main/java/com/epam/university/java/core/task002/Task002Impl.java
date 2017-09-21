package com.epam.university.java.core.task002;

public class Task002Impl implements Task002 {
    @Override
    public boolean isEquals(String firstString, String secondString) {
<<<<<<< HEAD
        if ((firstString == null || secondString == null)) {
            throw new IllegalArgumentException();
        }
        else if (firstString.equals( "" ) || secondString.equals( "" )) {
            return true;
        }
        else {
=======
        if((firstString==null||secondString==null)){
            throw new IllegalArgumentException();
        }
        else if(firstString.equals("")||secondString.equals("")){
            return true;
        }
        else{
>>>>>>> c27b7c3fd124118495fb597fdb747a97889106ce
            return firstString.equals(secondString);
        }
    }

    @Override
    public String left(String sourceString, int number) {
<<<<<<< HEAD
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        else if (number<0){
            throw new IllegalArgumentException();
        }
        else {
            if (number>sourceString.length()){
                return sourceString;
            }
            else {
                return sourceString.substring(0, number);
=======
        if(sourceString==null){
            throw new IllegalArgumentException();
        }
        else if(number<0){
            throw new IllegalArgumentException();
        }
        else{
            if(number>sourceString.length()){
                return sourceString;
            }
            else{
                return sourceString.substring(0,number);
>>>>>>> c27b7c3fd124118495fb597fdb747a97889106ce
            }
        }
    }

    @Override
    public String left(String sourceString, String separator) {
<<<<<<< HEAD
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }
        else {
=======
        if(sourceString==null||separator==null){
            throw new IllegalArgumentException();
        }
        else{
>>>>>>> c27b7c3fd124118495fb597fdb747a97889106ce
            return sourceString.split(separator)[0];
        }
    }

    @Override
    public String right(String sourceString, int number) {
<<<<<<< HEAD
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        else if (number < 0) {
            throw new IllegalArgumentException();
        }
        else {
            if (number>sourceString.length()){
                return sourceString;
            }
            else {
                return sourceString.substring(sourceString.length()-5, sourceString.length());
=======
        if(sourceString==null){
            throw new IllegalArgumentException();
        }
        else if(number<0){
            throw new IllegalArgumentException();
        }
        else{
            if(number>sourceString.length()){
                return sourceString;
            }
            else{
                return sourceString.substring(sourceString.length()-5,sourceString.length());
>>>>>>> c27b7c3fd124118495fb597fdb747a97889106ce
            }
        }
    }

    @Override
    public String right(String sourceString, String separator) {
<<<<<<< HEAD
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }
        else {
=======
        if(sourceString==null||separator==null){
            throw new IllegalArgumentException();
        }
        else{
>>>>>>> c27b7c3fd124118495fb597fdb747a97889106ce
            return sourceString.split(separator)[1];
        }
    }

    @Override
    public String[] split(String sourceString, String split) {
<<<<<<< HEAD
        if (sourceString == null || split == null) {
            throw new IllegalArgumentException();
        }
        else {
=======
        if(sourceString==null||split==null){
            throw new IllegalArgumentException();
        }
        else{
>>>>>>> c27b7c3fd124118495fb597fdb747a97889106ce
            return sourceString.split(split);
        }
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
<<<<<<< HEAD
        if (sourceCollection == null || glue == null) {
            throw new IllegalArgumentException();
        }
        else {
=======
        if(sourceCollection==null||glue==null){
            throw new IllegalArgumentException();
        }
        else{
>>>>>>> c27b7c3fd124118495fb597fdb747a97889106ce
            return sourceCollection[0]+glue+sourceCollection[1];
        }
    }
}
