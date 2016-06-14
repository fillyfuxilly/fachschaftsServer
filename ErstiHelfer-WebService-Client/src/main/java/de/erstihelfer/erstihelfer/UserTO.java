
package de.erstihelfer.erstihelfer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für userTO complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="userTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://erstihelfer.erstihelfer.de/}dataTransferObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="groupNr" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userTO", propOrder = {
    "groupNr",
    "id",
    "username"
})
public class UserTO
    extends DataTransferObject
{

    protected int groupNr;
    protected int id;
    protected String username;

    /**
     * Ruft den Wert der groupNr-Eigenschaft ab.
     * 
     */
    public int getGroupNr() {
        return groupNr;
    }

    /**
     * Legt den Wert der groupNr-Eigenschaft fest.
     * 
     */
    public void setGroupNr(int value) {
        this.groupNr = value;
    }

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Ruft den Wert der username-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Legt den Wert der username-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

}
