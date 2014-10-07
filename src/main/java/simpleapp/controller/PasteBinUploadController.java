package simpleapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import simpleapp.messaging.PasteBinService;

@Controller
@RequestMapping(value = "/pastebin")
public class PasteBinUploadController {
    private static final Logger logger = LoggerFactory.getLogger(PasteBinUploadController.class);

    @Autowired
    protected PasteBinService pasteBinService;

    @RequestMapping(value = "/upload", method = RequestMethod.GET )
    @ResponseBody
    public String sendToPasteBin(@RequestParam String content) {
        logger.trace("Uploading content:\n" + content + "\n");
        pasteBinService.upload(content);
        return "Success";
    }
}
