package com.example.kkulaproject.EmailService;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kkulaproject.datacalss.History;
import com.example.kkulaproject.datacalss.User;

@Service
public class EmailManage {
    @Autowired
    EmailSenderService service;

    public void sendemailattachment(User user, History history, String filename) throws MessagingException {
        service.sendEmailWithAttachment(history.getHistorydetails().getSendemail(),

                "เรียน" + history.getHistorydetails().getProfessor() + "\n" + "ข้าพเจ้านาย" + user.getName()
                        + " รหัสนักศึกษา " + user.getStudentid() + "\n" +
                        "ขอหยุดเรียนเนื่องจาก" + history.getHistorydetails().getDetails()
                        + "โดยขอหยุดเรียนตั้งแต่วันที่ "
                        + history.getStartdate() + " " + "ถึงวันที่ " + history.getEnddate() + "\n" +
                        "ดังนั้นจึงขอความกรุณาอาจารย์ เพื่อโปรดให้ข้าพเจ้าได้ลาหยุด โดยที่ในระหว่างการลานี้สามารถติดต่อข้าพเจ้าได้ที่ เบอร์โทรศัพท์ "
                        + history.getHistorydetails().getPhone() + "\n"
                        + "ซึ่งเมื่อครบกำหนดแล้วข้าพเจ้าจะมาเรียนตามปกติ" + "\n" + "\n" +
                        "ขอแสดงความนับถือ" + "\n" + "นาย" + user.getName() + "\n" + user.getName()
                , "ใบลาของนาย" + user.getName()
                , "Files-Upload\\" + new StringBuffer(history.getHistorydetails().getFileURL()).delete(0, 13) + "-"
                        + filename);
    }

    public void sendSimpleEmail(User user, History history) {
        service.sendSimpleEmail(history.getHistorydetails().getSendemail(), "เรียน"
                + history.getHistorydetails().getProfessor() + "\n" + "ข้าพเจ้านาย" + user.getName()
                + " รหัสนักศึกษา " + user.getStudentid() + "\n" +
                "ขอหยุดเรียนเนื่องจาก" + history.getHistorydetails().getDetails() + "โดยขอหยุดเรียนตั้งแต่วันที่ "
                + history.getStartdate() + " " + "ถึงวันที่ " + history.getEnddate() + "\n" +
                "ดังนั้นจึงขอความกรุณาอาจารย์ เพื่อโปรดให้ข้าพเจ้าได้ลาหยุด โดยที่ในระหว่างการลานี้สามารถติดต่อข้าพเจ้าได้ที่ เบอร์โทรศัพท์ "
                + history.getHistorydetails().getPhone() + "\n" + "ซึ่งเมื่อครบกำหนดแล้วข้าพเจ้าจะมาเรียนตามปกติ" + "\n"
                + "\n" +
                "ขอแสดงความนับถือ" + "\n" + "นาย" + user.getName() + "\n" + user.getName(),
                "ใบลาของนาย" + user.getName());
    }
}
