package br.com.movieflix.streaming.service;

import br.com.movieflix.category.dto.CategoryDTO;
import br.com.movieflix.category.model.CategoryEntity;
import br.com.movieflix.streaming.dto.StreamingDTO;
import br.com.movieflix.streaming.mapper.StreamingMapper;
import br.com.movieflix.streaming.model.StreamingEntity;
import br.com.movieflix.streaming.repository.StreamingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StreamingService {

    private final StreamingRepository repository;
    private final StreamingMapper streamingMapper;

    public StreamingService(StreamingRepository repository, StreamingMapper streamingMapper) {
        this.repository = repository;
        this.streamingMapper = streamingMapper;
    }

    public List<StreamingDTO> getAllStreamings() {
        List<StreamingEntity> streaming = repository.findAll();
        return streaming.stream()
                .map(streamingMapper::map)
                .collect(Collectors.toList());
    }

    public StreamingDTO createStreaming(StreamingDTO streamingDTO) {
        StreamingEntity streaming = streamingMapper.map(streamingDTO);
        streaming = repository.save(streaming);
        return streamingMapper.map(streaming);
    }

    public StreamingDTO getStreamingById(Long id) {
        Optional<StreamingEntity> streaming = repository.findById(id);
        return streaming.map(streamingMapper::map).orElse(null);
    }

    public void deleteStreamingByid(Long id) {
        repository.deleteById(id);
    }



}
