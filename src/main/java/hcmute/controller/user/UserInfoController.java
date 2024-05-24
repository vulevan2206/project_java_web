package hcmute.controller.user;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hcmute.entity.UserEntity;
import hcmute.model.UserModel;
import hcmute.service.IUserService;

@Controller
@RequestMapping("user_infor")
public class UserInfoController {

	@Autowired
	IUserService userService;

//	@GetMapping("/{user_id}")
//    public String viewuser(ModelMap model, @PathVariable("user_id") Integer userId) {
//        Optional<UserEntity> opt = userService.findById(userId);
//        
//        
//        if (opt.isPresent()) {
//            UserEntity user = opt.get();
//            
//                model.addAttribute("user", user);
//                return "user/user_infor";
//            
//        } else {
//            model.addAttribute("message", "Không tìm thấy thông tin khách hàng với ID: " + userId);
//            return "user/error";
//        }
//    }
  @GetMapping("/{user_id}")
  public String viewuser(ModelMap model, @PathVariable("user_id") Integer userId) {
      Optional<UserEntity> opt = userService.findById(userId);
      
      // Bảo mật web
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      String loggedInUsername = authentication.getName();
      if (opt.isPresent()) {
          UserEntity user = opt.get();
          // Kiểm tra xem người dùng đã xác thực có phải là người dùng được yêu cầu không
          if (user.getUsername().equals(loggedInUsername)) {
              model.addAttribute("user", user);
              return "user/user_infor";
          } else {
              // Nếu người dùng đã xác thực không phải là người dùng được yêu cầu
              model.addAttribute("message", "Bạn không có quyền truy cập vào thông tin của người dùng này.");
              return "user/error";
          }
      } else {
          model.addAttribute("message", "Không tìm thấy thông tin khách hàng với ID: " + userId);
          return "user/error";
      }
  }
	@PostMapping("/edit/{user_id}")
	public ModelAndView edit(ModelMap model, @PathVariable("user_id") Integer userId,
			RedirectAttributes redirectAttributes, @Valid @ModelAttribute("user") UserModel user,
			BindingResult result) {


		if (user != null) {
			UserEntity entity = userService.findById(userId).get();
			if (entity != null) {
				// Cập nhật thông tin người dùng
				entity.setName(user.getName());
				entity.setSurname(user.getSurname());
				entity.setGender(user.getGender());
				entity.setPhoneNumber(user.getPhoneNumber());

				userService.save(entity);
				redirectAttributes.addFlashAttribute("message", "Thông tin đã được cập nhật thành công!");
				redirectAttributes.addFlashAttribute("status", "success");
			}
		}
		return new ModelAndView("redirect:/user_infor/" + userId);

	}

}