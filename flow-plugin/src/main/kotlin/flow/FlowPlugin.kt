package flow

import org.gradle.api.Plugin
import org.gradle.api.Project

class FlowPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        // FLW-1 stub — taches flowStatus/flowMerge/flowClose/flowCICD/flowReport a venir (FLW-2..4)
        project.logger.lifecycle("flow-gradle plugin applied (stub FLW-1)")
    }
}