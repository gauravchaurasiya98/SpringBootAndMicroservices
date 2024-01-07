package in.gaurav.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/i18n")
public class WishMessageController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/wish/{user}")
    public ResponseEntity<String> wishGoodMorning(@PathVariable String user) {
		/*`en` - English (Good Morning)
		  `nl` - Dutch (Goedemorgen)
		  `fr` - French (Bonjour)
		  `de` - Deutsch (Guten Morgen)*/
        Locale locale = LocaleContextHolder.getLocale();
        String message = messageSource.getMessage(
                "good.morning.message",
                new String[]{user},
                "If provided key/code doesn't exist then default message will be rendered",
                locale);
        return ResponseEntity.ok(message);
    }
}
