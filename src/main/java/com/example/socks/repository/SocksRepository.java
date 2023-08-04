package com.example.socks.repository;

import com.example.socks.model.Sock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocksRepository extends JpaRepository<Sock, Long> {
    @Query("select s.count from Sock s where s.color = :color and s.cottonPart > :cottonPart")
    Long countAllByColorAndCottonPartGreaterThan(@Param("color") String color, @Param("cottonPart") Integer cottonPart);

    @Query("select s.count from Sock s where s.color = :color and s.cottonPart < :cottonPart")
    Long countAllByColorAndCottonPartLessThan(@Param("color") String color, @Param("cottonPart") Integer cottonPart);

    @Query("select s.count from Sock s where s.color = :color and s.cottonPart = :cottonPart")
    Long countAllByColorAndCottonPartEquals(@Param("color") String color, @Param("cottonPart") Integer cottonPart);

    @Modifying
    @Query("update Sock s set s.count = s.count - :count where s.color = :color and s.cottonPart = :cottonPart")
    void sellSocks(@Param("color") String color, @Param("cottonPart") Integer cottonPart, @Param("count") Long count);
    @Modifying
    @Query("update Sock s set s.count = s.count + :count where s.color = :color and s.cottonPart = :cottonPart")
    void addSocks(@Param("color") String color, @Param("cottonPart") Integer cottonPart, @Param("count") Long count);

    List<Sock> findAllByColorAndCottonPart(String color, Integer cottonPart);
}
