package cake.tz.constant;

public class SecurityConstant {
    public static final long EXPIRATION_TIME = 86_400_000; // 1 day in milliseconds
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String JWT_TOKEN_HEADER = "Jwt-Token";
    public static final String TOKEN_CANNOT_BE_VERIFIED = "Token cannot be verified";
    public static final String GET_TZCAKE_LLC = "Tz Cake, LLC";
    public static final String GET_TZCAKE_ADMINISTRATION = "User Management Portal";
    public static final String AUTHORITIES = "Authorities";
    public static final String FORBIDDEN_MESSAGE = "You need to log in to access this page";
    public static final String ACCESS_DENIED_MESSAGE = "You do not have permission to access this page";
    public static final String OPTIONS_HTTP_METHOD = "OPTIONS";
    public static final String[] PUBLIC_URLS = { "/user/login", "/user/register", "/user/forgotpassword/**", "/user/image/**" };
//    public static final String[] PUBLIC_URLS = { "**" };
}
