package kplc.resume;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResumepRepository extends JpaRepository<Resumep,Integer> {
    Resumep findByName(String name);
}
