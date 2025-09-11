package br.com.movieflix.streaming.mapper;

import br.com.movieflix.streaming.dto.StreamingDTO;
import br.com.movieflix.streaming.model.StreamingEntity;
import org.springframework.stereotype.Component;

@Component
public class StreamingMapper {

    public StreamingEntity map(StreamingDTO streamingDTO){
        StreamingEntity streaming = new StreamingEntity();
        streaming.setId(streamingDTO.getId());
        streaming.setName(streamingDTO.getName());
        return streaming;
    }

    public StreamingDTO map(StreamingEntity streamingEntity){
        StreamingDTO streaming = new StreamingDTO();
        streaming.setId(streamingEntity.getId());
        streaming.setName(streamingEntity.getName());
        return streaming;
    }
}
