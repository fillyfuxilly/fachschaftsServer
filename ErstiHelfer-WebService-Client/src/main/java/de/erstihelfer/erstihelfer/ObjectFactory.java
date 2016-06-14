
package de.erstihelfer.erstihelfer;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.erstihelfer.erstihelfer package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ChangeGroup_QNAME = new QName("http://erstihelfer.erstihelfer.de/", "changeGroup");
    private final static QName _ChangeGroupResponse_QNAME = new QName("http://erstihelfer.erstihelfer.de/", "changeGroupResponse");
    private final static QName _CreateAppointment_QNAME = new QName("http://erstihelfer.erstihelfer.de/", "createAppointment");
    private final static QName _CreateAppointmentResponse_QNAME = new QName("http://erstihelfer.erstihelfer.de/", "createAppointmentResponse");
    private final static QName _GetAppointments_QNAME = new QName("http://erstihelfer.erstihelfer.de/", "getAppointments");
    private final static QName _GetAppointmentsResponse_QNAME = new QName("http://erstihelfer.erstihelfer.de/", "getAppointmentsResponse");
    private final static QName _Login_QNAME = new QName("http://erstihelfer.erstihelfer.de/", "login");
    private final static QName _Login1_QNAME = new QName("http://erstihelfer.erstihelfer.de/", "login1");
    private final static QName _Login1Response_QNAME = new QName("http://erstihelfer.erstihelfer.de/", "login1Response");
    private final static QName _LoginResponse_QNAME = new QName("http://erstihelfer.erstihelfer.de/", "loginResponse");
    private final static QName _Logout_QNAME = new QName("http://erstihelfer.erstihelfer.de/", "logout");
    private final static QName _LogoutResponse_QNAME = new QName("http://erstihelfer.erstihelfer.de/", "logoutResponse");
    private final static QName _RegisterNewUser_QNAME = new QName("http://erstihelfer.erstihelfer.de/", "registerNewUser");
    private final static QName _RegisterNewUserResponse_QNAME = new QName("http://erstihelfer.erstihelfer.de/", "registerNewUserResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.erstihelfer.erstihelfer
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ChangeGroup }
     * 
     */
    public ChangeGroup createChangeGroup() {
        return new ChangeGroup();
    }

    /**
     * Create an instance of {@link ChangeGroupResponse }
     * 
     */
    public ChangeGroupResponse createChangeGroupResponse() {
        return new ChangeGroupResponse();
    }

    /**
     * Create an instance of {@link CreateAppointment }
     * 
     */
    public CreateAppointment createCreateAppointment() {
        return new CreateAppointment();
    }

    /**
     * Create an instance of {@link CreateAppointmentResponse }
     * 
     */
    public CreateAppointmentResponse createCreateAppointmentResponse() {
        return new CreateAppointmentResponse();
    }

    /**
     * Create an instance of {@link GetAppointments }
     * 
     */
    public GetAppointments createGetAppointments() {
        return new GetAppointments();
    }

    /**
     * Create an instance of {@link GetAppointmentsResponse }
     * 
     */
    public GetAppointmentsResponse createGetAppointmentsResponse() {
        return new GetAppointmentsResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link Login1 }
     * 
     */
    public Login1 createLogin1() {
        return new Login1();
    }

    /**
     * Create an instance of {@link Login1Response }
     * 
     */
    public Login1Response createLogin1Response() {
        return new Login1Response();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link Logout }
     * 
     */
    public Logout createLogout() {
        return new Logout();
    }

    /**
     * Create an instance of {@link LogoutResponse }
     * 
     */
    public LogoutResponse createLogoutResponse() {
        return new LogoutResponse();
    }

    /**
     * Create an instance of {@link RegisterNewUser }
     * 
     */
    public RegisterNewUser createRegisterNewUser() {
        return new RegisterNewUser();
    }

    /**
     * Create an instance of {@link RegisterNewUserResponse }
     * 
     */
    public RegisterNewUserResponse createRegisterNewUserResponse() {
        return new RegisterNewUserResponse();
    }

    /**
     * Create an instance of {@link UserLoginResponse }
     * 
     */
    public UserLoginResponse createUserLoginResponse() {
        return new UserLoginResponse();
    }

    /**
     * Create an instance of {@link ReturnCodeResponse }
     * 
     */
    public ReturnCodeResponse createReturnCodeResponse() {
        return new ReturnCodeResponse();
    }

    /**
     * Create an instance of {@link UserTO }
     * 
     */
    public UserTO createUserTO() {
        return new UserTO();
    }

    /**
     * Create an instance of {@link Appointment }
     * 
     */
    public Appointment createAppointment() {
        return new Appointment();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erstihelfer.erstihelfer.de/", name = "changeGroup")
    public JAXBElement<ChangeGroup> createChangeGroup(ChangeGroup value) {
        return new JAXBElement<ChangeGroup>(_ChangeGroup_QNAME, ChangeGroup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeGroupResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erstihelfer.erstihelfer.de/", name = "changeGroupResponse")
    public JAXBElement<ChangeGroupResponse> createChangeGroupResponse(ChangeGroupResponse value) {
        return new JAXBElement<ChangeGroupResponse>(_ChangeGroupResponse_QNAME, ChangeGroupResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateAppointment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erstihelfer.erstihelfer.de/", name = "createAppointment")
    public JAXBElement<CreateAppointment> createCreateAppointment(CreateAppointment value) {
        return new JAXBElement<CreateAppointment>(_CreateAppointment_QNAME, CreateAppointment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateAppointmentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erstihelfer.erstihelfer.de/", name = "createAppointmentResponse")
    public JAXBElement<CreateAppointmentResponse> createCreateAppointmentResponse(CreateAppointmentResponse value) {
        return new JAXBElement<CreateAppointmentResponse>(_CreateAppointmentResponse_QNAME, CreateAppointmentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAppointments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erstihelfer.erstihelfer.de/", name = "getAppointments")
    public JAXBElement<GetAppointments> createGetAppointments(GetAppointments value) {
        return new JAXBElement<GetAppointments>(_GetAppointments_QNAME, GetAppointments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAppointmentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erstihelfer.erstihelfer.de/", name = "getAppointmentsResponse")
    public JAXBElement<GetAppointmentsResponse> createGetAppointmentsResponse(GetAppointmentsResponse value) {
        return new JAXBElement<GetAppointmentsResponse>(_GetAppointmentsResponse_QNAME, GetAppointmentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erstihelfer.erstihelfer.de/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login1 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erstihelfer.erstihelfer.de/", name = "login1")
    public JAXBElement<Login1> createLogin1(Login1 value) {
        return new JAXBElement<Login1>(_Login1_QNAME, Login1 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login1Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erstihelfer.erstihelfer.de/", name = "login1Response")
    public JAXBElement<Login1Response> createLogin1Response(Login1Response value) {
        return new JAXBElement<Login1Response>(_Login1Response_QNAME, Login1Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erstihelfer.erstihelfer.de/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Logout }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erstihelfer.erstihelfer.de/", name = "logout")
    public JAXBElement<Logout> createLogout(Logout value) {
        return new JAXBElement<Logout>(_Logout_QNAME, Logout.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erstihelfer.erstihelfer.de/", name = "logoutResponse")
    public JAXBElement<LogoutResponse> createLogoutResponse(LogoutResponse value) {
        return new JAXBElement<LogoutResponse>(_LogoutResponse_QNAME, LogoutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterNewUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erstihelfer.erstihelfer.de/", name = "registerNewUser")
    public JAXBElement<RegisterNewUser> createRegisterNewUser(RegisterNewUser value) {
        return new JAXBElement<RegisterNewUser>(_RegisterNewUser_QNAME, RegisterNewUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterNewUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erstihelfer.erstihelfer.de/", name = "registerNewUserResponse")
    public JAXBElement<RegisterNewUserResponse> createRegisterNewUserResponse(RegisterNewUserResponse value) {
        return new JAXBElement<RegisterNewUserResponse>(_RegisterNewUserResponse_QNAME, RegisterNewUserResponse.class, null, value);
    }

}
