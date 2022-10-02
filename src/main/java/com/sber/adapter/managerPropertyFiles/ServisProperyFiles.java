package com.sber.adapter.managerPropertyFiles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface ServisProperyFiles {
    public List<Path> getAllPropertyFilesPaths();
    public List<ConfigurationPropertyFiles> readConfigFiles() throws IOException;
}
