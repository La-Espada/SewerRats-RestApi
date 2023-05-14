package com.sewerrats.sewerratsapp.service.mutatecommand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateSewerUserMutateCommand {
    private Long id;
    private String discordTag;
    private String discordUsername;
    private String profilePicture;
}
