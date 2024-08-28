package com.tinqinacademy.bff.core.converters.comment;

import com.tinqinacademy.bff.api.model.comment.user.get.GetCommentsOutputBFF;
import com.tinqinacademy.bff.api.model.comment.user.get.GetCommentsOutputItemBFF;
import com.tinqinacademy.comment.api.model.user.get.GetCommentsOutput;
import com.tinqinacademy.comment.api.model.user.get.GetCommentsOutputItem;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserGetCommentsConverter implements Converter<GetCommentsOutput, GetCommentsOutputBFF> {
    @Override
    public GetCommentsOutputBFF convert(GetCommentsOutput source) {
        return GetCommentsOutputBFF.builder()
                .commentsOutputList(convertList(source.getCommentsOutputList()))
                .build();
    }
    private List<GetCommentsOutputItemBFF> convertList(List<GetCommentsOutputItem> given){
        return given.stream().map(item -> GetCommentsOutputItemBFF.builder()
                .id(item.getId())
                .firstName(item.getFirstName())
                .lastName(item.getLastName())
                .publishDate(item.getPublishDate())
                .lastEditedBy(item.getLastEditedBy())
                .lastEditedDate(item.getLastEditedDate())
                .content(item.getContent())
                .build())
                .toList();
    }
}
