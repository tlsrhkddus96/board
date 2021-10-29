package org.rhkddus.board.service;

import org.junit.jupiter.api.Test;
import org.rhkddus.board.dto.BoardDTO;
import org.rhkddus.board.dto.PageRequestDTO;
import org.rhkddus.board.dto.PageResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardServiceTests {

    @Autowired
    BoardService boardService;

    @Test
    public void testRegister(){

        BoardDTO dto = BoardDTO.builder()
                .title("test....")
                .content("Test...")
                .writerEmail("user55@aaa.com")
                .build();

        Long bno = boardService.register(dto);

    }

    @Test
    public void testList(){

        PageRequestDTO pageRequestDTO = new PageRequestDTO();

        PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);

        for(BoardDTO boardDTO : result.getDtoList()){
            System.out.println(boardDTO);
        }

    }

    @Test
    public void testGet(){

        Long bno = 100L;

        BoardDTO boardDTO = boardService.get(bno);

        System.out.println(boardDTO);

    }

    @Test
    public void testRemove(){

        Long bno = 2L;

        boardService.removeWithReplies(bno);

    }

    @Test
    public void testModify(){

        BoardDTO boardDTO = BoardDTO.builder()
                .bno(99L)
                .title("제목 변경")
                .content("내용 변경")
                .build();

        boardService.modify(boardDTO);

    }

}
