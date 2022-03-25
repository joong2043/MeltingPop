package com.example.meltingpop.repository;

import com.example.meltingpop.dto.BoardDto;
import com.example.meltingpop.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Long은 Board 엔티티의 기본키의 데이터타입으로 명시해줘야 한다.
@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

//MySQL에 있는 Board 데이터에 대한 접근이 필요하면 작성
    //List<BoardDto> findByBoardTitleAndWriter(String boardTitle,String boardWriter);

}
