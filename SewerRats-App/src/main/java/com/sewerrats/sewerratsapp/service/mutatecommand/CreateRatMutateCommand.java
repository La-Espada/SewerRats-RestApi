package com.sewerrats.sewerratsapp.service.mutatecommand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateRatMutateCommand {
    private String ratName;
    private String ratType;
    private double ratPrice;
    private double ratPossibility;
    private double ratHealth;
    private double ratSpeed;
    private double ratDefense;
    private double ratDamage;
    private int ratCount;
    private String ratHat;
    private String ratBase;
    private String ratEyes;

}
