package com.devrection.testsecurity.service;

import com.devrection.testsecurity.dto.JoinDTO;
import com.devrection.testsecurity.entity.UserEntity;
import com.devrection.testsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDTO joinDTO) {

        boolean isUser  = userRepository.existsByUsername(joinDTO.getUsername());
        if(isUser ) {
            throw new IllegalArgumentException("중복된 아이디가 존재합니다.");
        }

        UserEntity data = new UserEntity();
        data.setUsername(joinDTO.getUsername());
        data.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword()));
        data.setRole("ROLE_USER");
        userRepository.save(data);
    }
}
