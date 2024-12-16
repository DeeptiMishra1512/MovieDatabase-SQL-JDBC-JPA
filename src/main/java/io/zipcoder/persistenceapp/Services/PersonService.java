package io.zipcoder.persistenceapp.Services;
import io.zipcoder.persistenceapp.DTO.Person;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

 /**Private Integer id;
    private String firstName;
    private String lastName;
    private String mobileNum;
    private Date birthday;
    private Integer homeID;
*/
/**CREATE TABLE PERSON (
  ID INT NOT NULL AUTO_INCREMENT,
  FIRST_NAME VARCHAR2(255) NOT NULL DEFAULT '',
  LAST_NAME VARCHAR2(255) NOT NULL DEFAULT '',
  MOBILE VARCHAR2(20) NOT NULL DEFAULT '',
  BIRTHDAY DATE DEFAULT NULL,
  HOME_ID SMALLINT DEFAULT NULL,
  PRIMARY KEY (ID));

 */


    private Person extractPersonDetailsFromResultSet(ResultSet rs) throws SQLException {
        Person person = new Person();

        person.setId( rs.getInt("ID") );
        person.setFirstName( rs.getString("FIRST_NAME") );
        person.setLastName( rs.getString("LAST_NAME") );
        person.setMobileNum( rs.getString("MOBILE") );
        person.setBirthday(rs.getDate("BIRTHDAY"));
        person.setHomeID(rs.getInt("HOME_ID"));

        return person;
    }


    public Person findById(int id) {

        /**Get connection using object of Connection class and method getConnection()*/
        Connection connection = ConnectionFactory.getConnection();
        try {

            /** Build QUERY to be used in prepare statement */
            String query = "SELECT * FROM PERSON WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);


            /** Prepare Result Set */
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractPersonDetailsFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }


    public List<Person> findAllByName(String Fname, String Lname){

        List<Person> allPeople = new ArrayList<>();

        /**Get connection using object of Connection class and method getConnection()*/
        Connection connection = ConnectionFactory.getConnection();

        try
        {
            /**set the query to be used in prepare statement. */
            String query = "Select * from Person where FIRST_NAME = ? AND LAST_NAME = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            //Set string values for the parameters.
            statement.setString(1,Fname);
            statement.setString(2,Lname);

        /** Set the result set to print the select statement */
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                allPeople.add(extractPersonDetailsFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
          try{
              if(connection != null)
                  connection.close();
          }catch(SQLException e){
              e.printStackTrace();
          }
        }

        return allPeople;
    }

public Person update(String mobileNum, int ID){

    Person updatePerson = new Person();

    Connection connection = ConnectionFactory.getConnection();
    try {
        String query = "Update Person set MOBILE = ? where ID = ?";
        PreparedStatement stat = connection.prepareStatement(query);

        stat.setString(1,mobileNum);
        stat.setInt(2,ID);

        int rowsUpdated = stat.executeUpdate();
        if(rowsUpdated >0){
            return updatePerson;
        }

    }catch(SQLException e){
        e.printStackTrace();
    }finally{
        try{
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return null;
}


public void delete(int ID){
        Person P1 = new Person();

        Connection connect = ConnectionFactory.getConnection();
    try {
        String delQuery = "delete from Person where ID = ?";
        PreparedStatement S1 = connect.prepareStatement(delQuery);
        S1.setInt(1,ID);
        S1.executeUpdate();

    }catch(SQLException e){
        e.printStackTrace();
    }finally{
        try {
            if(connect != null)
                connect.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
/**CREATE TABLE PERSON (
 ID INT NOT NULL AUTO_INCREMENT,
 FIRST_NAME VARCHAR2(255) NOT NULL DEFAULT '',
 LAST_NAME VARCHAR2(255) NOT NULL DEFAULT '',
 MOBILE VARCHAR2(20) NOT NULL DEFAULT '',
 BIRTHDAY DATE DEFAULT NULL,
 HOME_ID SMALLINT DEFAULT NULL,
 PRIMARY KEY (ID));

 */

public boolean insert(Person person){

        Connection Con = ConnectionFactory.getConnection();

        try{
            String query = "insert into Person(FIRST_NAME,LAST_NAME,MOBILE,BIRTHDAY,HOME_ID) values(?, ?, ?, ?, ?)";
            PreparedStatement S1 = Con.prepareStatement(query);

            S1.setString(1,person.getFirstName());
            S1.setString(2,person.getLastName());
            S1.setString(3,person.getMobileNum());
            S1.setDate(4,person.getBirthday());
            S1.setInt(5,person.getHomeID());

           int result =  S1.executeUpdate();
           S1.execute();
           if(result> 0) {
               return true;
           }

        }catch(SQLException e){
            e.printStackTrace();;
        }finally{
            try {
                if (Con != null)
                    Con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
}


}
