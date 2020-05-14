package ru.itis.socialnetworkboot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.socialnetworkboot.model.Dialog;
import ru.itis.socialnetworkboot.model.User;
import ru.itis.socialnetworkboot.repository.interfaces.DialogRepository;
import ru.itis.socialnetworkboot.repository.interfaces.MessagesRepository;

import java.util.Optional;

@Controller
public class ChatController {

    private final DialogRepository dialogRepository;
    private final MessagesRepository messagesRepository;

    private Dialog dialog;

    public ChatController(DialogRepository dialogRepository, MessagesRepository messagesRepository) {
        this.dialogRepository = dialogRepository;
        this.messagesRepository = messagesRepository;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/chat")
    public String chatPage() {

//        Optional<User> optionalUser = (Optional<User>) authentication.getPrincipal();
//        User authUser = optionalUser.get();
//
//        model.addAttribute("userId", authUser.getUserId());
//        model.addAttribute("dialog", dialog);

        return "chat";
    }

    // В реквесте кому хочу отправиь сообщение
    // здесь я узнаю в какой диалог его отправить
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/dialog/{userId}")
    public String dialog(Authentication authentication, @PathVariable Long userId) {

        Optional<User> optionalUser = (Optional<User>) authentication.getPrincipal();
        User authUser = optionalUser.get();
        User sendTo = new User(userId);

        Optional<Dialog> dialog1 = dialogRepository.findByUser1AndUser2(authUser, sendTo);
        Optional<Dialog> dialog2 = dialogRepository.findByUser1AndUser2(sendTo, authUser);

        if(!dialog1.isPresent() && !dialog2.isPresent()) {

            Dialog dialog = Dialog.builder()
                    .user1(authUser)
                    .user2(sendTo)
                    .build();

            dialogRepository.save(dialog);
            Dialog created = dialogRepository.findByUser1AndUser2(authUser, sendTo).get();
            this.dialog = created;

//            return "/dialog/room/" + created.getDialogId();

        }

        else if(dialog1.isPresent()) {
            dialog = dialog1.get();
//            return "/dialog/room/" + dialog1.get().getDialogId();
        }

        else if(dialog2.isPresent()) {
            dialog = dialog2.get();
//            return "/dialog/room/" + dialog2.get().getDialogId();
        }

        return "redirect:/chat";

    }
//
//    @PreAuthorize("isAuthenticated()")
//    @GetMapping("/dialog/room/{dialogId}")
//    public String getDialogMessages(Model model,
//                            Authentication authentication,
//                            @PathVariable Long dialogId) {
//
//        model.addAttribute("messages", messagesRepository.findAllByDialogOrderByDateDesc(new Dialog(dialogId)));
//        model.addAttribute("roomId", dialogId);
//
//        User user1 = dialog.getUser1();
//        Optional<User> optionalUser = (Optional<User>) authentication.getPrincipal();
//
//        if(user1.equals(optionalUser.get())) {
//            model.addAttribute("with", dialog.getUser2());
//        }
//        else {
//            model.addAttribute("with", dialog.getUser1());
//        }
//
//        return "messages";
//
//    }
//
//    @PreAuthorize("isAuthenticated()")
//    @PostMapping("/dialog/room/{dialogId}")
//    public void putMessage(Authentication authentication,
//                           @PathVariable Long dialogId) {
//
//        Optional<User> optionalUser = (Optional<User>) authentication.getPrincipal();
//
//    }

}
