package com.sewerrats.sewerratsapp.service.mutatecommand;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddRatToSewerUserMutateCommand {
    private String username;
    private Long ratId;
}
