/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.buss;

import org.casaortiz.dao.PersonDao;
import org.casaortiz.model.Person;

/**
 *
 * @author jorge
 */
public class PersonBuss {
   private PersonDao perDao;
   
   public PersonBuss(){
       perDao = new PersonDao();
   }
   
   public void savePerson(Person item) throws Exception{
       item.setFirstName((item.getFirstName().trim().replaceAll(" +", " ")).toUpperCase());
       item.setLastName((item.getLastName().trim().replaceAll(" +", " ")).toUpperCase());
       perDao.insert(item);
   }
}
