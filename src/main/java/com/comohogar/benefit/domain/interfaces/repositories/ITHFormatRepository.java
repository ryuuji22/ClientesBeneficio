package com.comohogar.benefit.domain.interfaces.repositories;

import java.io.IOException;
import java.util.Optional;

import com.comohogar.benefit.domain.entities.THFormat;

public interface ITHFormatRepository {

	Optional<THFormat> getTHFormat() throws IOException;


}
