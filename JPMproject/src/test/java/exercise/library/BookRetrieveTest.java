/* * BookTest * Version: 0.1 * * Copyright (c) Altran Europe 2008 * 
This software is the confidential and proprietary information of * Altran Europe. 
You shall not disclose such Confidential Information * 
and shall use it only in accordance with the terms of the license 
* agreement you entered into with Altran Europe. */
package exercise.library;
/**
 * Created by ${SJA} on ${17-FEB-2015}.
 *
 */

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * * @author sjayachandran * @version 0.1 4/05/2015
 */

@RunWith(Parameterized.class)

public class BookRetrieveTest {


    //private String bookResult;
    private String bookInput;
    private String expectedBook;

    private String isbn;


    public BookRetrieveTest(String expectedBook, String bookInput){

        this.expectedBook = expectedBook;
        this.bookInput = bookInput;

    }
    @Parameterized.Parameters
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][] {
                { "BookNameNotCorrectException"  , "INVALID-TEXT" },
                {  "BookNotFoundException" , "ISBN-777" },
                { "Harry Potter and the Deathly Hallows", "ISBN-001" }
        });
    }


    @Test
    public void retrieveBooktest (){

        BookRepository br = new BookRepositoryImpl();
        try {
            Book book =  br.retrieveBook(bookInput);

            if(book!= null){
                Assert.assertEquals(expectedBook, book.getTitle());
            }

        } catch (BookNotFoundException e) {
            e.printStackTrace();
        } catch (BookNameNotCorrectException e) {
            e.printStackTrace();
        }

    }

}

   