/* * BookNameNotCorrectException * Version: 0.1 * * Copyright (c) Altran Europe 2008 * 
This software is the confidential and proprietary information of * Altran Europe. 
You shall not disclose such Confidential Information * 
and shall use it only in accordance with the terms of the license 
* agreement you entered into with Altran Europe. */
package exercise.library;
/**
 * Created by ${SJA} on ${17-FEB-2015}.
 *
 */

/**
 * * @author sjayachandran * @version 0.1 4/05/2015
 */
public class BookNameNotCorrectException extends Exception{


    public BookNameNotCorrectException(String message) {


         super("The book isbn must begin with 'ISBN'");


    }
}

   