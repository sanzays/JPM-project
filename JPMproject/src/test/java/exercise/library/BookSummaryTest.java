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

/**
 * * @author sjayachandran * @version 0.1 4/05/2015
 */

@RunWith(Parameterized.class)

public class BookSummaryTest {


    //private String bookResult;
    private String bookInput;
    private String expectedBook;

    private String isbn;


    public BookSummaryTest(String expectedBook, String bookInput){

        this.expectedBook = expectedBook;
        this.bookInput = bookInput;

    }
    @Parameterized.Parameters
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][] {
                { "BookNameNotCorrectException"  , "INVALID-TEXT" },
                { "BookNotFoundException" , "ISBN-777" },
                { "[ISBN-001]-Harry Potter and the Deathly Hallows-Sorcery and Magic.", "ISBN-001" },
                { "[ISBN-002]-The Player of Games-Jernau Morat Gurgeh. The Player of Games. Master of every ...", "ISBN-002"},
                { "[ISBN-003]-Genius: Richard Feynman and Modern Physics-A brilliant interweaving of Richard Feynman's colourful life and a ...", "ISBN-003"}
        });
    }


    @Test
    public void bookSummaryTest (){

        BookRepository br = new BookRepositoryImpl();
        try {
            String bookDescTitle =  br.getBookSummary(bookInput);

            if(bookDescTitle!= null && !"expectedBook".equals(bookDescTitle)){
                Assert.assertEquals(expectedBook, bookDescTitle);
            }
            else{

                throw new BookNotFoundException();
            }

        } catch (BookNotFoundException e) {
            e.printStackTrace();
        } catch (BookNameNotCorrectException e) {
            e.printStackTrace();
        }

    }

}

   