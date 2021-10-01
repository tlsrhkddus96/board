package org.rhkddus.board.service;

import org.junit.jupiter.api.Test;
import org.rhkddus.board.dto.ReplyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ReplyServiceTests {

    @Autowired
    private ReplyService service;


    @Test
    public void testGetList(){

        Long bno = 97L;

        List<ReplyDTO> replyDTOList = service.getList(bno);

        replyDTOList.forEach(replyDTO -> {
            System.out.println(replyDTO);
        });

    }


}
