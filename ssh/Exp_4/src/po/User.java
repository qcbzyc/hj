package po;

import java.io.Serializable;

public class User implements Serializable {
      private Integer intId;
      private String name;
      private  String password;
      public User(){}
      public User(Integer intId,String name,String password)
      {
          this.intId = intId;
           this.name = name;
           this.password =password;
      }

    /**
     * @return the intId
     */
    public Integer getIntId() {
        return intId;
    }

    /**
     * @param intId the intId to set
     */
    public void setIntId(Integer intId) {
        this.intId = intId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
