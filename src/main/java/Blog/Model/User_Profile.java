package Blog.Model;

import javax.persistence.*;

@Entity
@Table(name="user_profile")
public class User_Profile
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="fullname")
    private String fullName;

    @Column(name="Email")
    private String Email;

    @Column(name="Mobile")
    private String Mobile;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
      this.Email = Email;

    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;

    }

}
