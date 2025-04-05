package com.rakeshpoc.schoolapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "contact_msg")
@SqlResultSetMappings({
        @SqlResultSetMapping(name = "SqlResultSetMapping.count", columns = @ColumnResult(name = "cnt"))
})
@NamedQueries({
        @NamedQuery(name = "Contact.findOpenMsgs", query = "Select c from Contact c where c.status=:status"),
        @NamedQuery(name = "Contact.updateMsgStatusById", query = "UPDATE Contact c set c.status=?1 where c.contactId=?2")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "Contact.findOpenMsgsNative",
                query = "SELECT * FROM contact_msg c WHERE c.status = :status"
                ,resultClass = Contact.class),
        @NamedNativeQuery(name = "Contact.findOpenMsgsNative.count",
                query = "select count(*) as cnt from contact_msg c where c.status = :status",
                resultSetMapping = "SqlResultSetMapping.count"),
        @NamedNativeQuery(name = "Contact.updateMsgStatusByIdNative",
                query = "UPDATE contact_msg c SET c.status = ?1 WHERE c.contact_id = ?2")
})
public class Contact extends BaseEntity{
    @Id
    @Column(name="contact_id")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    private int contactId;
    @NotBlank(message = "Name should not be blank")
    @Size(min = 3,message = "Name must be atleast 3 char long")
    //@JsonProperty("contactName")
    private String name;
    @NotBlank(message = "Mobile Number should not be blank")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile Number must 10 digit")
    private String mobileNum;
    @NotBlank(message = "Email should not be blank")
    @Email(message = "Enter valid email id")
    private String email;
    @NotBlank(message = "Subject should not be blank")
    @Size(min = 10,message = "Subject must be atleast 10 char long")
    private String subject;
    @NotBlank(message = "Message should not be blank")
    @Size(min = 20,message = "Message must be atleast 20 char long")
    private String message;
    private String status;
}
