/**
 * 
 */
package mblog.web.controller.browse;

import mblog.core.service.MblogService;
import mblog.web.controller.BaseController;
import mtons.commons.pojos.Paging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author langhsu
 *
 */
@Controller
@RequestMapping("/browse")
public class GalleryController extends BaseController {
	@Autowired
	private MblogService mblogService;
	
	@RequestMapping("/gallery")
	public String view(Integer pageNo, ModelMap model) {
		Paging paging = wrapPaging(pageNo);
		mblogService.paging(paging);
		model.put("paging", paging);
		return "/browse/gallery";
	}
	
	@RequestMapping("/gallery_snippet/{pageNo}")
	public String snippet(@PathVariable Integer pageNo, ModelMap model) {
		Paging paging = wrapPaging(pageNo);
		mblogService.paging(paging);
		model.put("paging", paging);
		return "/browse/snippet";
	}
}
