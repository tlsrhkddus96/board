package org.rhkddus.board.repository.search;

import org.rhkddus.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchBoardRepository {



    Page<Object[]> searchPage(String type, String keyword, Pageable pageable);



}
