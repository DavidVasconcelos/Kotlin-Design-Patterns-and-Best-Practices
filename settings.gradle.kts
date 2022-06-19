rootProject.name = "kotlin-design-patterns"

for (chapter in 1..11) {
    include("Chapter${chapter.toString().padStart(2, '0')}")
}

