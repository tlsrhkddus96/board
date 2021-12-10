package org.rhkddus.board.service.board;

import lombok.RequiredArgsConstructor;
import org.rhkddus.board.dto.board.ReplyDTO;
import org.rhkddus.board.entity.Board;
import org.rhkddus.board.entity.Reply;
import org.rhkddus.board.repository.board.ReplyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{

    private final ReplyRepository replyRepository;

    @Override
    public void modify(ReplyDTO replyDTO) {

        Reply reply = dtoToEntity(replyDTO);

        replyRepository.save(reply);

    }

    @Override
    public void remove(Long rno) {

        replyRepository.deleteById(rno);


    }

    @Override
    public Long register(ReplyDTO replyDTO) {

        Reply reply = dtoToEntity(replyDTO);

        replyRepository.save(reply);

        return reply.getRno();

    }

    @Override
    public List<ReplyDTO> getList(Long bno) {


        List<Reply> result = replyRepository.getRepliesByBoardOrderByRno(Board.builder().bno(bno).build());

        return result.stream().map(reply -> entityToDTO(reply)).collect(Collectors.toList());
    }







}
