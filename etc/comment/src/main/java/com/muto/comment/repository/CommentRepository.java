package com.muto.comment.repository;

import com.muto.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("select max(groupNumber) from Comment")
    Optional<Integer> findCommentGroup();

    @Query("select max(groupOrder) from Comment where groupNumber = :groupNumber")
    Integer findCommentOrder(@Param("groupNumber") int groupNumber);
}
