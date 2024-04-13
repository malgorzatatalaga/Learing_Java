package projects.io.nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileTree {

    public Optional<String> tree(final Path path) {
        if (path == null || !Files.exists(path)) {
            return Optional.empty();
        }

        try {
            if (Files.isRegularFile(path)) {
                return Optional.of(path.getFileName().toString() + " " + Files.size(path) + " bytes");
            } else if (Files.isDirectory(path)) {
                StringBuilder builder = new StringBuilder();
                long totalSize = buildDirectoryTree(path, 0, builder, "");
                return Optional.of(path.getFileName().toString() + " " + totalSize + " bytes\n" + builder.toString().trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    private long buildDirectoryTree(Path directory, int level, StringBuilder builder, String prefix) throws Exception {
        try (Stream<Path> stream = Files.list(directory)) {
            List<Path> paths = stream
                    .sorted(Comparator.comparing((Path p) -> !Files.isDirectory(p))
                            .thenComparing(p -> p.getFileName().toString().toLowerCase()))
                    .collect(Collectors.toList());

            long totalSize = 0;
            for (int i = 0; i < paths.size(); i++) {
                Path p = paths.get(i);
                boolean isLast = (i == paths.size() - 1);
                String connector = isLast ? "└─ " : "├─ ";
                String newPrefix = prefix + (isLast ? "   " : "│  ");

                if (Files.isRegularFile(p)) {
                    long fileSize = Files.size(p);
                    totalSize += fileSize;
                    builder.append(prefix).append(connector).append(p.getFileName()).append(" ").append(fileSize).append(" bytes\n");
                } else if (Files.isDirectory(p)) {
                    StringBuilder subDirBuilder = new StringBuilder();
                    long dirSize = buildDirectoryTree(p, level + 1, subDirBuilder, newPrefix);
                    totalSize += dirSize;
                    builder.append(prefix).append(connector).append(p.getFileName()).append(" ").append(dirSize).append(" bytes\n").append(subDirBuilder);
                }
            }

            return totalSize;
        }
    }
}
