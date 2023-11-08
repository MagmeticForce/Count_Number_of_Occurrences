import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class Word_Count {

    public static ArrayList<String> get_words_from_file_and_store_in_arraylist (String file_name_input) throws FileNotFoundException {
        String[] temp_storage;
        ArrayList<String> array_list_output = new ArrayList<>();
        temp_storage = get_words_from_file_and_store_in_array(file_name_input);
        
        //transfer contents to array
        for (int i = 0; i < temp_storage.length; i++) {
            array_list_output.add (temp_storage[i]);
        }

        return array_list_output;

    }

    public static String[] get_words_from_file_and_store_in_array (String file_name_input) throws FileNotFoundException {
        
        //initialization
        Scanner file_reader = new Scanner (new File (file_name_input));
        ArrayList<String> temporary_storage_for_file_contents = new ArrayList<>();

        //add contents of the file into an temporary array list
        while (file_reader.hasNextLine()) {
            temporary_storage_for_file_contents.add(file_reader.nextLine());
        }
        file_reader.close();

        //copy contents from the temporary array list to a regular string array
        String[] array_output = new String [temporary_storage_for_file_contents.size()];
        for (int a = 0; a < temporary_storage_for_file_contents.size(); a++) {
            array_output[a] = temporary_storage_for_file_contents.get(a);
        }
        return array_output;

    }

    public static boolean check_if_two_words_are_the_same (String word_input1, String word_input2) {

        if (word_input1.equalsIgnoreCase(word_input2)) {
            //System.out.println("true"); //DEBUG
            return true;
        }
        else {
            //System.out.println("false"); //DEBUG
            return false;
        }
    }

    //array list definition of count_number_of_words
    public static ArrayList<String> get_number_of_word_occurrences (ArrayList<String> list_of_words_input) {

        String the_word_to_count_the_number_of_occurrences_for;
        ArrayList<Integer> word_occurrence_numbers = new ArrayList<>();
        ArrayList<String> word_occurrence_numbers_as_strings = new ArrayList<>();

        ArrayList<String> number_of_occurrences_output = new ArrayList<>();

        boolean it_is_the_same_word;

        int a = 1;

        //for each word in list_of_words_input, do the following:
        //store a copy of the word you're currently looking at (will be stored in "the_word_to_count_the_number_of_occurrences_for")
        //then look at the rest of the words one-by-one, and for each word, see if it's the same as "the_word_to_count_the_number_of_occurrences_for" (nested loop)
        for (int b = 0; b < list_of_words_input.size(); b++) {
        //original "while" condition: list_of_words_input.size() > 1 -- problem cuz it breaks when all rpeats are remove

            the_word_to_count_the_number_of_occurrences_for = list_of_words_input.get(b);
            //for every item stored in list_of_words_input, see if it's the same as the_word_to_count_the_number_of_occurrences_for
            //if they are the same, remove the currrent index and add 1 to the number of occurrences
            //if they aren't, check the next index.
            //keep in mind: "a" represents words being compared with, while "b" represents the current word your comparing
            a = b+1; //start by looking at the word that is next to the current word you're looking at
            word_occurrence_numbers.add(1);
            while (a < list_of_words_input.size()) {
                it_is_the_same_word = check_if_two_words_are_the_same(the_word_to_count_the_number_of_occurrences_for, list_of_words_input.get(a));
                if (it_is_the_same_word) {
                    list_of_words_input.remove (a);
                    word_occurrence_numbers.set(b, word_occurrence_numbers.get(b) + 1);
                }
                else {
                    a++;
                }

                /*
                //DEBUG:
                System.out.println(" ");
                System.out.println("ARRAYLIST AFTER COMPLETING THIS COMPARISON PHASE:");
                //print contents of array
                for (int i = 0; i < list_of_words_input.size(); i++) {
                    System.out.println(list_of_words_input.get(i));
                }
                System.out.println(" ");
                System.out.println("*****************************************************");
                System.out.println("*****************************************************");
                */

            }



            //DEBUG:
            //System.out.println("~~~~~~~~~~~~NEXT WORD~~~~~~~~~~~~");
        }

        //convert the integers in the array list "word_occurrence_numbers" to strings, and...
        //store those strings in "word_occurrence_numbers_as_strings" 
        for (int c = 0; c < word_occurrence_numbers.size(); c++) {
            word_occurrence_numbers_as_strings.add(Integer.toString(word_occurrence_numbers.get(c)));
        }

        /*
        //DEBUG:
        //print contents of word_occurrence_numbers
        for (int i = 0; i < word_occurrence_numbers_as_strings.size(); i++) {
            System.out.println (word_occurrence_numbers_as_strings.get(i));
        }
        */

        
        //combine the two array lists to form the number_of_occurrences_output
        for (int d = 0; d < word_occurrence_numbers_as_strings.size(); d++) {
            number_of_occurrences_output.add(list_of_words_input.get(d));
            number_of_occurrences_output.add(word_occurrence_numbers_as_strings.get(d));
        }
        

        return number_of_occurrences_output;
    }





    

    //array definition of count_number_of_words
    //allows user to input an regular array instea of an array list
    public static String[] get_number_of_word_occurrences (String[] list_of_words_input) {
        ArrayList<String> list_of_words_in_an_arraylist = new ArrayList<>();

        //copy contents from list_of_words_input to list_of_words_in_an_arraylist
        for (int i = 0; i < list_of_words_input.length; i++) {
            list_of_words_in_an_arraylist.set (i, list_of_words_input[i]);
        }

        ArrayList<String> number_of_occurrences_in_an_arraylist = new ArrayList<>();

        //now that list_of_words_in_an_arraylist has... 
        //...all the contents of the list_of_words_input array...
        //...go to the array list definition of the count_number_of_words function and...
        //...store the output into number_of_occurrences_in_an_arraylist
        number_of_occurrences_in_an_arraylist = get_number_of_word_occurrences(list_of_words_in_an_arraylist);

        String[] number_of_occurrences_array_output = new String[number_of_occurrences_in_an_arraylist.size()];

        //transfer contents from number_of_occurrences_in_an_arraylist to number_of_occurrences_array_output
        for (int i = 0; i < number_of_occurrences_in_an_arraylist.size(); i++) {
            number_of_occurrences_array_output[i] = number_of_occurrences_in_an_arraylist.get(i);
        }

        return number_of_occurrences_array_output;


    }



    public static void write_word_occurrences_to_file (ArrayList<String> array_list_input, String file_name_input) throws IOException {
        FileWriter file_writer = new FileWriter(file_name_input);

        //goes through each element of thre array argument and writes it on a new line of the file
        //the "array_argument.length - 1" and the extra "file_writer.write" after the loop prevents...
        //...an extra empty line from being printed
        for (int a = 0; a < array_list_input.size(); a++) {
            if (a < array_list_input.size() - 1) {
                file_writer.write(array_list_input.get(a) + "\n");
            }
            else {
                file_writer.write(array_list_input.get(a) + ""); //the + "" is necessary or else it writes "a" to the file for some reason
            }
        }

        file_writer.close();

    }

    public static void main (String[] args) throws Exception {

        String[] file_contents;
        ArrayList<String> file_contents_in_an_arraylist = new ArrayList<>();
        ArrayList<String> number_of_occurrences = new ArrayList<>();

        //System.out.println("File contents:"); //DEBUG


        file_contents_in_an_arraylist = get_words_from_file_and_store_in_arraylist("test.txt");
        
        /*
        //print contents stored in file_contents array
        for (int i = 0; i < file_contents.length; i++) {
            System.out.println(file_contents[i]);
        }
        */


        /*
        //DEBUG
        //print contents stored in file_contents array
        for (int i = 0; i < file_contents_in_an_arraylist.size(); i++) {
            System.out.println(file_contents_in_an_arraylist.get(i));
        }
        */

        /*
        //DEBUG:
        System.out.println(" ");
        System.out.println("********************************************************");
        System.out.println("********************************************************");
        System.out.println("********************************************************");
        System.out.println(" ");
        */

        number_of_occurrences = get_number_of_word_occurrences(file_contents_in_an_arraylist);

        /*
        //DEBUG:
        ///print ccontents of number_of_occurrences
        for (int i = 0; i < number_of_occurrences.size(); i++) {
            System.out.println(number_of_occurrences.get(i));
        }
        */

        write_word_occurrences_to_file(number_of_occurrences, "word_occurrences_of_test.txt");


    }
}