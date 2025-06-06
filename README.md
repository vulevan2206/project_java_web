# Lập trình web
- Đề tài: **Xây dụng website chuỗi bán trà sữa AloTra bằng SpringBoot + JSP + Bootstrap + JPA + SQLServer**
- Giáo viên hướng dẫn: ThS. Nguyễn Hữu Trung
- 
## Tổng quan
- Technical: **JSP** (**J**akarta **S**erver **P**ages) and **Servlet**
- Framework: Spring Boot
- Database:
    - Relational database management system : **Microsoft SQL Server**
    - Object-relational mapping : **Hibernate 5.4.10.Final**
- Front-end frameworks :
    - **Bootstrap**
    - **jQuery** 
    - **AJAX** 
- Design pattern : **Model - View - Controller (MVC)**
- Integrated development environment (IDE) : **Eclipse IDE for Enterprise Java and Web Developers - 2023-06**

## Hướng dẫn cài đặt và sử dụng
- Yêu cầu:
    -  Phải có Eclipse IDE for Enterprise Java and Web Developers và Microsoft SQL Server Management Studio tồn tại trên máy tính
    -  [Tải JDK phù hợp](https://www.oracle.com/java/technologies/downloads/) => Project đang sử dụng JDK 20
    -  [Tải apache-tomcat phù hợp](https://tomcat.apache.org/) => Project đang sử dụng apache-tomcat 10.1.14
    -  [Tải apache-maven phù hợp](https://maven.apache.org/download.cgi) => Project đang sử dụng apache-maven 3.9.4
    -  Cài một vài featured trong Eclipse MarketPlace:
        - Eclipse Enterprise Java and Web Developer Tools 3.30
        - Spring Tools 4 (aka Spring Tool Suite) 4.21.1.RELEASE
        - [Lombok](https://projectlombok.org/setup/eclipse)
- Các bước làm:
    - Clone project về thư mục: https://github.com/quangnghia1110/project_java_web.git
    - Tạo môi trường cho maven và jdk
    - Thực hiện restored database trong Microsoft SQL Server Management Studio 
    - Mở project vừa clone về trong Eclipse IDE for Enterprise Java and Web Developers
    - Tạo servers (ở đây là apache-tomcat)
    - Thực hiện update maven để nó download các thư viện về
    - Ấn Alt+Shift+X, B để có thể chạy project
- Tài khoản đăng nhập demo:
    - Quyền Admin:
      - Tài khoản: admin
      - Mật khẩu: 123456789 
    - Quyền Manager:
      - Tài khoản: manager
      - Mật khẩu: 123456789 
    - Quyền User:
      - Tài khoản: user
      - Mật khẩu: 123456789
- Lưu ý:
    - Các ảnh upload lên phải nằm trong đường dẫn: <b>C:\uploads</b>
    - Hướng dẫn cách thanh toán bằng VNPay: [VNPay](https://drive.google.com/file/d/1zPrMAw4PcjseSqqzCZrtUm2wpfuDdQ3n/view?usp=sharing)
    - Tạo mật khẩu ứng dụng để dử dụng gửi mail: [Mail](https://myaccount.google.com/u/1/apppasswords?rapt=AEjHL4Nn2OmjkHZ6MTBv9WjVQVHKaqF2LihjBb9p5l_JFHxGadm7UpecA1Z-VUp7m8yh3Im3lDhexnKboJIGKBchKZhSoI9YjSFfXZMzfIc-5F895K0EnXc)
    - Sử dụng một vài API trên [Google Developer Console](https://console.cloud.google.com/apis/library?project=indigo-codex-415011), để kích hoạt được API cần phải có thẻ VISA
      - Distance Matrix API (Tính phí ship và thời gian ship)
      - Google Maps Platform APIs (Gợi ý địa điểm gần đúng khi tìm kiếm)  
## Tài liệu
- File báo cáo: [Báo cáo đồ án cuối kỳ web](https://docs.google.com/document/d/1rvcV1ebBAdKZV1HEsryWoF85ZEwXXDcEEXm6TBcDcm0/edit?usp=sharing)
- File backup database: [projectJavaWeb.bak](https://drive.google.com/file/d/1vwR_-mr2Xb9uLyjfHoQL84ImQnnpbP9k/view?usp=sharing)

## Cấu trúc dự án
<pre>
<b>projectJavaWeb</b>
├── database
├── github
├── src
│   ├── main
│   │   ├── <b>java</b>
│   │   │   ├── <b>hcmute.config</b>
│   │   │   │   └── CrosConfig                 
│   │   │   │   └── CustomSiteMeshFilter     
│   │   │   │   └── MvcConfig                         
│   │   │   │   └── StorageProperties                
│   │   │   │   └── VNPayConfig                       
│   │   │   │   └── WebSecurityConfig                         
│   │   │   ├── <b>hcmute.controller</b>
│   │   │   │   └── admin 
│   │   │   │   └── api 
│   │   │   │   └── manager 
│   │   │   │   └── security
│   │   │   │   └── user     
│   │   │   ├── <b>hcmute.embeddedId</b>
│   │   │   │   └── BranchMilkTeaId 
│   │   │   │   └── CartDetailId 
│   │   │   │   └── OrderDetailId 
│   │   │   ├── <b>hcmute.entity</b>
│   │   │   │   └── BranchEntity
│   │   │   │   └── BranchMilkTea
│   │   │   │   └── CartDetailEntity
│   │   │   │   └── CartEntity
│   │   │   │   └── CityEntity
│   │   │   │   └── MilkTeaCategoryEntity
│   │   │   │   └── MilkTeaEntity
│   │   │   │   └── MilkTeaTypeEntity
│   │   │   │   └── OrderDetailEntity
│   │   │   │   └── OrderEntity
│   │   │   │   └── PayMethodEntity
│   │   │   │   └── RoleEntity
│   │   │   │   └── UserEntity
│   │   │   │   └── UserRoleEntity
│   │   │   ├── <b>hcmute.exception</b>
│   │   │   │   └── GlobalExceptionHandler
│   │   │   │   └── OAuth2AuthenticationProcessingException
│   │   │   │   └── ResourceNotFoundException
│   │   │   │   └── StorgeException
│   │   │   │   └── StoreFileNotFoundException
│   │   │   ├── <b>hcmute.model</b>
│   │   │   │   └── AuthProvider
│   │   │   │   └── BranchModel
│   │   │   │   └── BranchMilkTeaModel
│   │   │   │   └── CartDetailModel
│   │   │   │   └── CartModel
│   │   │   │   └── CityModel
│   │   │   │   └── MilkTeaCategoryModel
│   │   │   │   └── MilkTeaModel
│   │   │   │   └── MilkTeaTypeModel
│   │   │   │   └── OrderData
│   │   │   │   └── OrderDetailModel
│   │   │   │   └── OrderModel
│   │   │   │   └── OrderProduct
│   │   │   │   └── PayMethodModel
│   │   │   │   └── UserModel
│   │   │   │   └── UserRoleModel
│   │   │   ├── <b>hcmute.repository</b>
│   │   │   │   └── BranchRepository
│   │   │   │   └── BranchMilkTeaRepository
│   │   │   │   └── CartDetailRepository
│   │   │   │   └── CartRepository
│   │   │   │   └── CityRepository
│   │   │   │   └── MilkTeaCategoryRepository
│   │   │   │   └── MilkTeaRepository
│   │   │   │   └── MilkTeaTypeRepository
│   │   │   │   └── OrderDetailRepository
│   │   │   │   └── OrderRepository
│   │   │   │   └── PayMethodRepository
│   │   │   │   └── RoleRepository
│   │   │   │   └── UserRepository
│   │   │   │   └── UserRoleRepository
│   │   │   ├── <b>hcmute.security</b>
│   │   │   │   └── user
│   │   │   │       └── FacebookOAuth2UserInfo
│   │   │   │       └── GoogleOAuth2UserInfo
│   │   │   │       └── OAuth2UserInfo
│   │   │   │       └── OAuth2UserInfoFactory
│   │   │   │   └── CustomOauth2User
│   │   │   │   └── CustomOauth2UserService
│   │   │   │   └── OAuthLoginSuccessHandler
│   │   │   ├── <b>hcmute.service</b>
│   │   │   │   └── impl
│   │   │   │       └── BranchServiceImpl
│   │   │   │       └── BranchMilkTeaServiceImpl
│   │   │   │       └── CartDetailServiceImpl
│   │   │   │       └── CartServiceImpl
│   │   │   │       └── CityServiceImpl
│   │   │   │       └── ForgotPasswordServiceImpl
│   │   │   │       └── MilkTeaCategoryServiceImpl
│   │   │   │       └── MilkTeaServiceImpl
│   │   │   │       └── MilkTeaTypeServiceImpl
│   │   │   │       └── OrderDetailServiceImpl
│   │   │   │       └── OrderServiceImpl
│   │   │   │       └── PayMethodServiceImpl
│   │   │   │       └── RoleServiceImpl
│   │   │   │       └── StorgeServiceImpl
│   │   │   │       └── UserServiceImpl
│   │   │   │       └── UserRoleServiceImpl
│   │   │   │   └── IBranchService
│   │   │   │   └── IBranchMilkTeaService
│   │   │   │   └── ICartDetailService
│   │   │   │   └── ICartService
│   │   │   │   └── ICityService
│   │   │   │   └── IForgotPasswordService
│   │   │   │   └── IMilkTeaCategoryService
│   │   │   │   └── IMilkTeaService
│   │   │   │   └── IMilkTeaTypeService
│   │   │   │   └── IOrderDetailService
│   │   │   │   └── IOrderService
│   │   │   │   └── IPayMethodService
│   │   │   │   └── IRoleService
│   │   │   │   └── IStorgeService
│   │   │   │   └── IUserService
│   │   │   │   └── IUserRoleService
│   │   │   ├── <b>hcmute.utils</b>
│   │   │   │   └── CommonUtils
│   │   │   │   └── ProjectApplication
│   │   │   │   └── ServletInitalizer
│   │   ├── <b>resources</b>
│   │   │   │   └── static
│   │   │   │       └── admin
│   │   │   │           └── assets
│   │   │   │           └── css
│   │   │   │           └── js
│   │   │   │       └── security
│   │   │   │           └── img
│   │   │   │       └── user
│   │   │   │           └── css
│   │   │   │           └── js
│   │   │   │   └── application.properties
│   │   ├── <b>webapp</b>
│   │   │   │   └── common
│   │   │   │       └── admin
│   │   │   │           └── footer
│   │   │   │           └── header
│   │   │   │       └── manager
│   │   │   │           └── footer
│   │   │   │           └── header
│   │   │   │       └── user
│   │   │   │           └── footer
│   │   │   │           └── header
│   │   │   │       └── taglib.jsp
│   │   │   │   └── decorators
│   │   │   │       └── admin.jsp
│   │   │   │       └── manager.jsp
│   │   │   │       └── user.jsp
│   │   │   │   └── WEB-INF
│   │   │   │       └── admin
│   │   │   │           └── customize
│   │   │   │           └── view
│   │   │   │           └── index.jsp
│   │   │   │       └── error
│   │   │   │           └── 403.jsp
│   │   │   │       └── manager
│   │   │   │           └── customize
│   │   │   │           └── view
│   │   │   │           └── index.jsp
│   │   │   │       └── security
│   │   │   │           └── change-password
│   │   │   │           └── forgot-password
│   │   │   │           └── login
│   │   │   │           └── register
│   │   │   │       └── user
│   │   │   │           └── branches_info.jsp
│   │   │   │           └── branches.jsp
│   │   │   │           └── cart.jsp
│   │   │   │           └── error.jsp
│   │   │   │           └── favorite.jsp
│   │   │   │           └── home.jsp
│   │   │   │           └── order.jsp
│   │   │   │           └── payment.jsp
│   │   │   │           └── product_detail.jsp
│   │   │   │           └── product.jsp
│   │   │   │           └── search.jsp
│   │   │   │           └── user_info.jsp
│   │   │   │       └── web.xml
├── uploads
└── pom.xml
</pre>
